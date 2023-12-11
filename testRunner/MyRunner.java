package assignment01.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		          features=".//Feature",
		          glue= {"assignment01/stepDefinations","assignment01/hooks"},
		          tags = "@iphoneTest or @FilterTest ",
		          plugin = {
		        		     "pretty",
		        		     "html:reports/cucumber-reports"
		          },
		          dryRun=false          
		)
public class MyRunner {
	
}
