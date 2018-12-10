package lt.bta.java2.repositories;

import lt.bta.java2.model.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "dept")
public interface DepartmentRepository extends PagingAndSortingRepository<Department, String> {

    @RestResource(path="byName")
    List<Department> findByDeptName(@Param("name") String deptName);

}
