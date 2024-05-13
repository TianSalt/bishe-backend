package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Teacher;
import org.apache.ibatis.annotations.*;

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
    int insert(Teacher teacher);

    @Update("""
            UPDATE teacher
            SET name=#{name}, employee_id=#{employeeId}, password_hash=#{passwordHash}
            WHERE uid = #{uid}""")
    int update(Teacher teacher);

    Teacher getByEidAndPassword(String employeeId, String passwordHash);
}
