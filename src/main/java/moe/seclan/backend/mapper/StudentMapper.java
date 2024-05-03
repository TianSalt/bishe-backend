package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT COUNT(*) FROM student")
    Integer count();

    List<Student> get(String studentId, String name, String major, String schoolClass);

    @Select("SELECT * FROM student WHERE uid = #{uid}")
    Student getByUid(Integer uid);

    @Delete("DELETE FROM student WHERE uid = #{uid}")
    void delete(Integer uid);

    @Insert("""
            INSERT INTO student(student_id, name, major, school_class)
            values (#{studentID}, #{name}, #{major}, #{schoolClass})""")
    Integer insert(Student student);

    @Update("""
            UPDATE student
            SET
                student_id = #{studentId},
                name = #{name},
                major = #{major},
                school_class = #{schoolClass}
            WHERE
                uid = #{uid}""")
    Integer update(Student student);

    @Select("SELECT * FROM student WHERE student_id = ${studentId} AND name = #{name}")
    Student getBySidAndName(String studentId, String name);
}
