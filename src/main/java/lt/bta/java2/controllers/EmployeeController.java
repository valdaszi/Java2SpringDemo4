package lt.bta.java2.controllers;

import lt.bta.java2.model.Employee;
import lt.bta.java2.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public ModelAndView list(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                             @RequestParam(name = "size", required = false, defaultValue = "10") int size) {

        Page<Employee> pageResponse = this.employeeRepository.findAll(PageRequest.of(page - 1, size));

        Map<String, Object> map = new HashMap<>();
        map.put("pagingUrl", "employee");
        map.put("employees", pageResponse.getContent());
        map.put("pageNumber", pageResponse.getPageable().getPageNumber() + 1);
        map.put("pageSize", pageResponse.getSize());
        map.put("offset", pageResponse.getPageable().getOffset());
        map.put("totalElements", pageResponse.getTotalElements());
        map.put("totalPages", pageResponse.getTotalPages());

        return new ModelAndView("employee", map);
    }
}
