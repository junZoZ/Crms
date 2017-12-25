package xmu.crms.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xmu.crms.entity.School;
import xmu.crms.service.SchoolService;
import xmu.crms.vo.SchoolVO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @ResponseStatus(value= HttpStatus.OK)
    @GetMapping("/school")
    public List<SchoolVO> getSchools(@RequestParam(value = "city",required = false) String city) {
        List<SchoolVO> list = new ArrayList<>();
        List<School> schools = schoolService.listSchoolByCity(city);
        for(School temp:schools){
            SchoolVO vo=new SchoolVO();
            vo.setId(temp.getId().intValue());
            vo.setCity(temp.getCity());
            vo.setName(temp.getName());
            vo.setProvince(temp.getProvince());
            list.add(vo);
        }
        return list;
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @PostMapping("/school")
    public Integer createSchool(@RequestBody SchoolVO schoolVO) {
        School school = new School();
        school.setName(schoolVO.getName());
        school.setProvince(schoolVO.getProvince());
        school.setCity(schoolVO.getCity());
        BigInteger schoolId = schoolService.insertSchool(school);
        return schoolId.intValue();
    }
}
