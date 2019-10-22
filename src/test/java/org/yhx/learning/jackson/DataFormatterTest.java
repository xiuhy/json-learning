package org.yhx.learning.jackson;

import org.testng.annotations.Test;
import org.yhx.learning.jackson.entity.Transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.util.Data 默认情况下会被序列号成millSeconds 的时间戳
 */
public class DataFormatterTest extends BaseTest {

    @Test
    public void testSerializerWithDefaultDataFormat()throws Exception{

        Transaction transaction=new Transaction("transaction",new Date());

        System.out.println(this.objectMapper.writeValueAsString(transaction));
    }

    @Test
    public void testSerializerWithData()throws Exception{

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.objectMapper.setDateFormat(simpleDateFormat);
        Transaction transaction=new Transaction("transaction",new Date());
        System.out.println(this.objectMapper.writeValueAsString(transaction));
    }

    /**
     * 通过millSeconds 时间戳 json字符串可以转换成java.util.date 格式
     * @throws Exception
     */
    @Test
    public void testDeSerializeData()throws Exception{
        String json="{\"type\":\"transaction\",\"date\":1571248029301}";
        Transaction  transaction=this.objectMapper.readValue(json,Transaction.class);
        System.out.println(transaction.getDate());
    }
}
