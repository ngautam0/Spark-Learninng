import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object WordCount {
  
  def main(args: Array[String]){
    val conf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)
    
    val textFile = sc.textFile("./data/words.txt")
    
    
    val counts = textFile.flatMap(line => line.split(" "))
                    .map(word => (word,1))
                    .reduceByKey(_ + _)
                    
    counts.saveAsTextFile("./data/count")
    

  }
}