package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", publish = true, tags= "@test and not @wip")
//padores de anotacoes: @test(cenarios/funcionalidade concluidos), @wip(cenarios/funcionalidade em desenvolvimento), @smoke(cenarios/funcionalidade que nao podem quebrar)
//ex para rodar ou nao alguma tag: "@test" = execucao; "not @wip" = não executar o cenario marcado com a tag.

public class Runner {
}
