import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import com.tribbloids.spookystuff.actions._
import com.tribbloids.spookystuff.dsl._

/**
  * Created by fabiofumarola on 10/01/16.
  */
object SimpleApp {

  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Test")
    val sc = new SparkContext(conf)
    val spooky = new com.tribbloids.spookystuff.SpookyContext(sc)
    import spooky.dsl._

    val df = spooky.wget("https://news.google.com/?output=rss&q=barack%20obama"
    ).join(S"item title".texts)(
      Wget(x"http://api.mymemory.translated.net/get?q=${'A}&langpair=en|fr")
    )('A ~ 'title, S"translatedText".text ~ 'translated).toDF()


    val csv = df.toCSV()

    csv.foreach(println)
  }
}
