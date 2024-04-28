package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("SELECT * FROM teacher")
    List<Teacher> getAll();

    @Select("SELECT * FROM teacher WHERE uid = #{uid}")
    Teacher getByUid(Integer uid);

    @Delete("DELETE FROM teacher WHERE uid = #{uid}")
    void delete(Integer uid);

    @Insert("""
            INSERT INTO teacher(employee_id, name, password_hash)
            values (#{employeeId}, #{name}, #{passwordHash})""")
    void insert(Teacher teacher);
}
