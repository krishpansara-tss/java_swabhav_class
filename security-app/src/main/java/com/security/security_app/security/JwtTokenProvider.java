    package com.security.security_app.security;


    import com.security.security_app.exceptions.UserApiException;
    import io.jsonwebtoken.ExpiredJwtException;
    import io.jsonwebtoken.Jwts;
    import io.jsonwebtoken.MalformedJwtException;
    import io.jsonwebtoken.UnsupportedJwtException;
    import io.jsonwebtoken.io.Decoders;
    import io.jsonwebtoken.security.Keys;
    import jakarta.websocket.Decoder;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.http.HttpStatus;
    import org.springframework.security.core.Authentication;
    import org.springframework.stereotype.Component;

    import javax.crypto.SecretKey;
    import java.net.Authenticator;
    import java.security.Key;
    import java.util.Date;
    import java.util.List;

    @Component
    public class JwtTokenProvider {
        @Value("${jwt.expiration}")
        private Long jwtExpirationDate;

        @Value("${jwt.secret}")
        private String jwtSecret;

        public  String generateToken(Authentication authentication){
            String userName = authentication.getName();
            Date currentDate = new Date();
            Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate );

            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(auth -> auth.getAuthority())
                    .toList();

            String token = Jwts.builder().claims()
                    .subject(userName).issuedAt(currentDate).expiration(expireDate)
                    .and()
                    .signWith(key())
//                    .claim("role", authentication.getAuthorities())
                    .claim("role", roles)
                    .compact();

            return token;
        }

        private SecretKey key() {
            return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        }

        public boolean validateToken(String token){
            try{
                System.out.println("Expiry : "+ jwtExpirationDate);
                System.out.println("secrate : "+ jwtSecret);
                Jwts.parser().verifyWith(key()).build().parseSignedClaims(token);
                return true;
            }catch(MalformedJwtException ex){
                throw new UserApiException(HttpStatus.BAD_REQUEST, "Invalid JWT token");
            }catch (ExpiredJwtException ex){
                throw new UserApiException(HttpStatus.BAD_REQUEST, "Expired JWT token");
            } catch (UnsupportedJwtException ex){
                throw new UserApiException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
            } catch (IllegalArgumentException ex){
                throw new UserApiException(HttpStatus.BAD_REQUEST, "Invalid Exception");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public String getUsername(String token) {
            return Jwts.parser()
                    .verifyWith(key())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        }
    }
