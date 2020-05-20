import org.apache.kafka.clients.producer._
import java.util.Properties

object Producer extends App {

    writeToKafka("hello-kafka")


  def writeToKafka(topic: String): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9094")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)

    val record = new ProducerRecord[String, String](topic, "key", "value")

    producer.send(record)

    producer.close()
  }
}
