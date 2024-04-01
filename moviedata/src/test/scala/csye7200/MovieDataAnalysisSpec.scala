package csye7200

import csye7200.MovieDataAnalysis.outputDF
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
class MovieDataAnalysisSpec extends AnyFlatSpec with Matchers{

  it should "calculate correct mean rating" in {
    val expectedMeanRating = 3.59
    val df=outputDF()
    val meanRating = MovieDataAnalysis.calculateMeanRating(df)
    assert(meanRating === expectedMeanRating)
  }

  it should "calculate correct standard deviation of rating" in {
    val expectedStdDev = 1.06
    val df=outputDF()
    val stdDev = MovieDataAnalysis.calculateStdDevRating(df)
    assert(stdDev === expectedStdDev)
  }
}
