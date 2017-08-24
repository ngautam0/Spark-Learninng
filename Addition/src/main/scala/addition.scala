import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object addition {
  def main(args : Array[String]){
    
    val conf = new SparkConf().setAppName("addition").setMaster("local")
    val sc = new  SparkContext(conf)
    
    val data = Array(1,2,3,4,5,6)
    
    val rddData = sc.parallelize(data)
    
    println (rddData.reduce((a,b) => a + b))
     
  }
}