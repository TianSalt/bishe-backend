package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT COUNT(*) FROM student")
    Integer count();

    List<Student> getPages(String name, String major, String schoolClass, Integer start, Integer limit);

    @Delete("DELETE FROM student WHERE student_id = #{studentId}")
    void delete(Integer studentId);

    @Insert("INSERT INTO student(student_id, name, major, school_class)" +
            "values (#{studentID}, #{name}, #{major}, #{schoolClass})")
    void insert(Student student);
}
