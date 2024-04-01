package csye7200


import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import scala.math.sqrt

object MovieDataAnalysis {
  println("Source from https://www.kaggle.com/datasets/rishitjavia/netflix-movie-rating-dataset?select=Netflix_Dataset_Rating.csv")

  def outputDF():DataFrame={
    val spark = SparkSession.builder()

      .appName("Titanic Survival Prediction")
      .master("local[*]") // Change this to run on a cluster
      .getOrCreate()

    val df = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv("src\\main\\resources\\Netflix_Dataset_Rating.csv")
    df
  }


  def calculateMeanRating(df: DataFrame): Double = {
    val meanRating = df.select(avg("Rating")).collect()(0)(0).asInstanceOf[Double]
    BigDecimal(meanRating).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  def calculateStdDevRating(df: DataFrame): Double = {
    val mean=calculateMeanRating(df)
    val sumSquaredDiff = df.selectExpr(s"sum(pow(Rating - $mean, 2))").collect()(0)(0).asInstanceOf[Double]
    val count = df.count()
    val result=sqrt(sumSquaredDiff / count)
    BigDecimal(result).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
  }


}
