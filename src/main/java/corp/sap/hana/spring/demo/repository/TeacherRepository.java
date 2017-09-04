package corp.sap.hana.spring.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import corp.sap.hana.spring.demo.model.Teacher;

public interface TeacherRepository extends PagingAndSortingRepository<Teacher, String> {

}
