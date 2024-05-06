package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Exam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ExamMapper {

    List<Exam> get(Integer examId, Integer creator, Boolean isPublished,
                   String title, LocalDateTime fromTime, LocalDateTime toTime);

    @Delete("DELETE FROM exam WHERE exam_id = #{examId}")
    void delete(Integer examId);

    @Options(keyProperty = "examId", useGeneratedKeys = true)
    @Insert("""
            INSERT INTO exam (
                creator,
                is_published,
                title,
                start_time,
                end_time,
                introduction
            )
            VALUES (
                #{creator},
                #{isPublished},
                #{title},
                #{startTime},
                #{endTime},
                #{introduction}
            )""")
    void insert(Exam exam);

    //    @Update("""
//        UPDATE exam
//        SET creator = #{creator},
//            is_published = #{isPublished},
//            exam_name = #{examName},
//            start_time = #{tartTime},
//            title = #{title},
//            introduction = #{introduction}
//        WHERE exam_id = #{examId}
//        """)
    void update(Exam exam);

}
