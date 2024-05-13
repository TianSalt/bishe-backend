package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM admin")
    List<Admin> getAll();

    @Select("SELECT * FROM admin WHERE uid = #{uid}")
    Admin getByUid(Integer uid);

    @Delete("DELETE FROM admin WHERE uid = #{uid}")
    void delete(Integer uid);

    @Insert("""
            INSERT INTO admin(uid, username, password_hash)
            values (#{uid}, #{username}, #{passwordHash})""")
    Integer insert(Admin admin);

    @Update("""
            UPDATE admin
            SET username=#{username}, password_hash=#{passwordHash}
            WHERE uid = #{uid}""")
    Integer update(Admin admin);

    Admin getByUsernameAndPassword(String username, String passwordHash);

}
