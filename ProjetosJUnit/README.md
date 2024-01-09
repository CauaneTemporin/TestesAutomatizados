# JUnit
JUnit é um framework de teste unitário para a linguagem de programação Java. Ele fornece anotações para identificar métodos de teste, assertivas para verificar resultados esperados e outras funcionalidades para simplificar a escrita e execução de testes unitários.

### Principais características do JUnit incluem:

1. Anotações:  O JUnit utiliza anotações Java para identificar métodos de teste. Alguns exemplos são @Test para indicar um método de teste, @Before e @After para métodos que devem ser executados antes e depois de cada teste, respectivamente.

2. Assertivas: O JUnit fornece um conjunto de métodos de assertiva (por exemplo, assertEquals, assertTrue, assertNotNull) para verificar se os resultados obtidos em testes são os esperados.

3. Test Runners: O framework possui diferentes "runners" que controlam a execução dos testes. O BlockJUnit4ClassRunner é usado para execução de testes JUnit 4.

### Annotations usadas nas classes de teste
|Annotations |Descrição|
| ---------------------|----------------------- |
| @SpringBootTest|Carrega o contexto da aplicação (teste de integração)|
|@SpringBootTest @AutoConfigureMockMvc|Carrega o contexto da aplicação (teste de integração & web)Trata as requisições sem subir o servidor|
|@WebMvcTest(Classe.class)|Carrega o contexto, porém somente da camada web (teste de unidade: controlador)|
|@ExtendWith(SpringExtension.class)|Não carrega o contexto, mas permite usar os recursos do Spring com JUnit (teste de unidade: service/component)|
|@DataJpaTest|Carrega somente os componentes relacionados ao Spring Data JPA. Cada teste é transacional e dá rollback ao final. (teste de unidade: repository)|

# JUnit 5
O JUnit 5 é a próxima geração do popular framework de teste para Java, construído com base nas lições aprendidas com as versões anteriores do JUnit. Ele oferece uma série de recursos avançados e melhorias em comparação com o JUnit 4. Vamos explorar alguns dos conceitos chave do JUnit 5 com exemplos e explicações completas.

1. Anotações Básicas:

- @Test: Indica que o método é um teste.
- @BeforeEach: Indica que o método deve ser executado antes de cada teste.
- @AfterEach: Indica que o método deve ser executado após cada teste.
- @BeforeAll: Indica que o método deve ser executado antes de todos os testes.
- @AfterAll: Indica que o método deve ser executado após todos os testes.

Exemplo:
``` java
import org.junit.jupiter.api.*;

public class MyTest {

    @BeforeAll
    static void setup() {
        // Código de inicialização global
    }

    @BeforeEach
    void init() {
        // Código de inicialização para cada teste
    }

    @Test
    void myTestMethod() {
        // Lógica de teste
    }

    @AfterEach
    void tearDown() {
        // Código de limpeza após cada teste
    }

    @AfterAll
    static void done() {
        // Código de limpeza global
    }
}
``` 

2. Asserções:

JUnit 5 utiliza o conjunto de métodos Assertions para verificar as condições dos testes.
Exemplo:
``` java
import static org.junit.jupiter.api.Assertions.*;

@Test
void testSum() {
    assertEquals(5, 2 + 3);
}
``` 

3. Testes Parametrizados:

Permite executar o mesmo teste com diferentes conjuntos de dados.
Exemplo:
``` java
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ParameterizedTest
@ValueSource(ints = {1, 2, 3})
void testWithValueSource(int argument) {
    assertTrue(argument > 0 && argument < 4);
}
```

4. Testes Condicionais:

Execute um teste apenas se uma condição específica for atendida.
Exemplo:
``` java
@Test
@EnabledOnOs(OS.MAC)
void testOnMac() {
    // Este teste é executado apenas no sistema operacional macOS
}
```

5. Testes de Exceção:

Verifica se uma exceção específica é lançada.
Exemplo:
``` java
@Test
void testException() {
    assertThrows(IllegalArgumentException.class, () -> {
        throw new IllegalArgumentException("Mensagem de exceção");
    });
}
```
