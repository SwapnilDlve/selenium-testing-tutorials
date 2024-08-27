package features;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(plugin =  {"pretty","html:target/cucumber-report.html",
							"json:target/cucumber.json",
							"junit:target/report.xml"},   // to generate different reports
							features = {"src/test/resources/features/shout.feature",  
										"src/test/resources/features/login3.feature",
										"src/test/resources/features/cucumber.feature"}, // to link .feature files
							glue = {"ui.stepdefs","noui.stepdefs","util"},  // to link .class files in packages other than features
							/*tags = "not (@smoke and @valid)"*/
									tags = "@smoke",
//							dryRun = true,
//							snippets = SnippetType.CAMELCASE,  //to change the generated method formatting
							publish=true)        //to publish report online so that it can be shared
public class CucumberRunnerTest {

}