package testRunner;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectPackages;

import io.cucumber.junit.platform.engine.Constants;
 
@Suite
@IncludeEngines("cucumber")
@SelectPackages("feature")
@ConfigurationParameter(
  key = Constants.GLUE_PROPERTY_NAME,
  value = "stepDefinations")
@ConfigurationParameter(
  key = Constants.FILTER_TAGS_PROPERTY_NAME,
  value = "@activity1")
 


public class Activity1TestRunner {

}
