package com.tssconsultancy.core.services;

import com.tssconsultancy.core.dto.InstructorCourseCountDTO;
import com.tssconsultancy.core.dto.InstructorRequestDTO;
import com.tssconsultancy.core.dto.InstructorResponseDTO;
import com.tssconsultancy.core.mapper.InstructorMapper;
import com.tssconsultancy.core.models.Course;
import com.tssconsultancy.core.models.Instructor;
import com.tssconsultancy.core.reposetory.CourseRepository;
import com.tssconsultancy.core.reposetory.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InstructorServicesImpl implements InstructorServices {

    private final InstructorRepository instructorRepository;
    private  final InstructorMapper instructorMapper;
    private final CourseRepository courseRepository;

    @Override
    public Instructor addNewInstructor(InstructorRequestDTO instructorRequestDTO) {
        Instructor instructor = new Instructor();

        instructor.setInstructorName(instructorRequestDTO.getInstructorName());
        instructor.setDesignation(instructorRequestDTO.getDesignation());
        instructor.setSalary(instructorRequestDTO.getSalary());
        instructor.setCourseList(new ArrayList<>());
        System.out.println("befire savce"  + instructor);

        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }

    @Override
    public void assignCourseToInstructor(Long courseId, Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(
                () -> new RuntimeException("Instructor Having ID:" + instructorId + " doesn't exists.")
        );
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course Having ID:" + courseId + " doesn't exists.")
        );

        course.setInstructor(instructor);
        courseRepository.save(course);
    }

//    @Override
//    public InstructorResponseDTO findInstructorById(Long instructorId) {
//        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(
//                () -> new RuntimeException("Instructor Having ID: "+ instructorId + " doesn't exists")
//        );
//        return  instructorMapper.toResponse(instructor);
//    }

    public Integer getCountOfCourseByInstructor(Long instructorId){
        return instructorRepository.getCountByInstructorId(instructorId);
    }

    public Instructor findInstructorById(Long instructorId) {
         return  instructorRepository.findById(instructorId).orElseThrow(
                () -> new RuntimeException("Instructor Having ID: "+ instructorId + " doesn't exists")
        );
    }

    @Override
    public List<Course> getCourseOfInstructor(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(
                () -> new RuntimeException("Instructor Having ID: " + instructorId + " doesn't exists")
        );

        return instructor.getCourseList();
    }
//


    @Override
    public List<InstructorCourseCountDTO> getAllInstructorCourseCount() {
        return instructorRepository.getAllInstructorCourseCount().stream()
            .map(obj -> new InstructorCourseCountDTO(
                    (String) obj[0],
                    (Long) obj[1]
            ))
            .toList();
    }

    public boolean canDeleteInstructor(Long inst_id){
        return instructorRepository.getCountByInstructorId(inst_id) == 0;
    }
}
