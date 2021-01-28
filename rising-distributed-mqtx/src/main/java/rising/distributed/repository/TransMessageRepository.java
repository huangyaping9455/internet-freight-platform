package rising.distributed.repository;


import com.rising.common.web.base.BaseRepository;
import org.springframework.stereotype.Repository;
import rising.distributed.po.TransMessage;

import java.util.List;

@Repository
public interface TransMessageRepository extends BaseRepository<TransMessage, String> {

//    @Insert("replace INTO trans_message (id ,type, service, exchange, routing_key, queue, sequence, payload, date) " +
//            "VALUES(#{id}, #{type}, #{service},#{exchange},#{routingKey},#{queue},#{sequence}, #{payload},#{date})")
//    void insert(TransMessage transMessage);

//    @Update("update trans_message set type =#{type}, service =#{service}, exchange =#{exchange}, " +
//            "routing_key =#{routingKey}, queue =#{queue}, sequence =#{sequence}, payload =#{payload}, date =#{date} " +
//            "where id=#{id} and service = #{service}")
//    void update(TransMessage transMessage);

    void updateByIdAndService(String id, String service);

    //    @Select("SELECT id, type, service, exchange, routing_key routingKey, queue, sequence, payload, date FROM " +
//            "trans_message " +
//            "WHERE id = #{id} and service = #{service}")
    TransMessage selectByIdAndService(String id, String service);

    //    @Select("SELECT id, type, service, exchange, routing_key routingKey, queue, sequence, payload, date FROM " +
//            "trans_message WHERE type = #{type} and service = #{service}")
    List<TransMessage> selectByTypeAndService(String type, String service);

    //    @Delete("DELETE FROM trans_message WHERE id = #{id} and service = #{service}")
    void deleteByIdAndService(String id, String service);

}
