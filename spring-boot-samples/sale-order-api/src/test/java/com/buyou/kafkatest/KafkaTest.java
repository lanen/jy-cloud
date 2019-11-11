package com.buyou.kafkatest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Properties;
import java.util.UUID;

/**
 * @author evan
 * create date 2019/9/4
 */
public class KafkaTest {

    static class BinlogFileOffset{
        private String binlogFilename;
        private long offset;
        private int rowsToSkip;

        public BinlogFileOffset(String binlogFilename, long offset, int rowsToSkip) {
            this.binlogFilename = binlogFilename;
            this.offset = offset;
            this.rowsToSkip = rowsToSkip;
        }

        public String getBinlogFilename() {
            return binlogFilename;
        }

        public long getOffset() {
            return offset;
        }

        public int getRowsToSkip() {
            return rowsToSkip;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {

        Properties props = new Properties();
        props.put("bootstrap.servers", "10.16.18.46:9092");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("acks","-1");
        props.put("retries",3);
        props.put("batch.size",323840);
        props.put("linger.ms",10);
        props.put("buffer.memory",33554432);
        props.put("max.block.ms",3000);

        ObjectMapper mapper = new ObjectMapper();
        BinlogFileOffset offset = new BinlogFileOffset("mysql-bin.000001",0, 0);


//        Producer<String,String>  producer = new KafkaProducer<String, String>(props);
//        producer.send(new ProducerRecord<>("offset.storage.topic",1, mapper.writeValueAsString(offset)));
//        producer.close();
    }
}
