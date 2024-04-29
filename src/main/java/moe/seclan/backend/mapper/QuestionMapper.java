package moe.seclan.backend.mapper;

import moe.seclan.backend.pojo.Question;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface QuestionMapper {

    List<Question> get(Integer questionId, Integer creator,
                       Integer questionType, String content);

    @Select("SELECT * FROM question WHERE question_id = #{questionId}")
    Question getById(Integer questionId);

    @Insert("""
            INSERT INTO question(creator, question_type, content, correct_answer)
            VALUES (#{creator}, #{questionType}, #{content}, #{correctAnswer})""")
    void insert(Question question);

    @Update("""
            UPDATE question
            SET creator = ${creator}, question_type = #{questionType}, 
                content = #{content}, correct_answer = #{correctAnswer}
            WHERE question_id = #{questionId}""")
    void update(Question question);

    @Delete("DELETE FROM question WHERE question_id = #{questionId}")
    void delete(Integer questionId);
}
