# trabalhopoosaude
UAL - Unidades de Saúde

  Pretende-se a implementação de um sistema de planeamento de serviços em unidades de saúde. Uma unidade de saúde coordena vários profissionais de saúde, com várias categorias. A unidade presta serviço a uma população de utentes, cujos indivíduos distingue entre várias faixas etárias. Cada indivíduo pode ainda pertencer a uma família. A Tabela 1 e a Tabela 2 apresentam as categorias e faixas etárias a considerar.

Tabela 1. Categorias de profissionais de saúde
Ordem Categoria
  1    Medicina
  2    Enfermagem
  3    Auxiliar

Tabela 2. Faixas etárias da população de utentes.
Ordem Faixa Etária
  1   Jovem
  2   Adulto
  3   Idoso


  A unidade de saúde disponibiliza vários serviços: consultas médicas, serviços de enfermagem, e pequenas cirurgias. Estes serviços podem ser administrados por um profissional, ou por uma equipa de profissionais.
  Alguns serviços estão relacionados entre si,no sentido em que uma pequena cirurgia é antecedida por uma consulta, e precedida por uma sequência de serviços de enfermagem e/ou outra consulta. A Tabela 3 apresenta os serviços disponíveis, e a Tabela 4 apresenta a relação entre serviço e categorias, i.e., que categorias podem estar associadas a marcações de cada serviço.

Tabela 3. Tipos de serviço prestados a utentes
Ordem  Serviço        Anterior  Posterior
  1    Consulta            -         -
  2    PequenaCirurgia  Consulta Consulta
  3    Enfermagem          -         -     

Tabela 4. Afetações de categorias a serviços
Serviço           Categorias
Consulta          Medicina
PequenaCirurgia   Medicina, Enfermagem, Auxiliar
Enfermagem        Enfermagem, Auxiliar


O  trabalho  deve  permitir  o  planeamento  da  utilização  de  serviços  por  parte  de  utentes,  com  a identificação dos vários serviços a utilizar, e profissionais de saúde envolvidos. A entrada de instruções, e o seu resultado deve cumprir com as regras descritas nesta secção.
