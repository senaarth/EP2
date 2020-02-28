

# EP2 - OO 2019.2 (UnB - Gama)

Aluno Arthur Manuel Florencio Sena
Matricula 180030345
Data de entrega: 12/11/2019

## Descrição

Jogo da cobra com os tres tipos de cobra e 4 tipos de fruta implementados.

## Tipos de Snakes

Deve ser implementado ao menos 3 tipos de Snakes:
* **Comum:** A Snake classica, sem habilidades especiais. COR AZUL
* **Kitty:** Essa Snake tem as habilidades de atravessar as barreiras do jogo, mas não pode atravessar as bordas nem a si mesma. COR VERMELHA
* **Star:** Recebe o dobro de pontos ao comer as frutas. COR VERDE

## Frutas

As frutas são elementos que aparecem aleatoriamente e são os objetivos das Snakes. As frutas devem desaparecer em um tempo especifico e não devem aparecer mais de duas frutas por vez. Devem ser implementados ao menos 4 tipos de frutas:

* **Simple Fruit:** Fruta comum, dá um ponto e aumenta o tamanho da cobra. COR AMARELA
* **Bomb Fruit:** Essa fruta deve levar a morte da Snake. COR VERMELHA
* **Big Fruit:** Dá o dobro de pontos da Simple Fruit e aumenta o tamanho da cobra da mesma forma que a Simple Fruit. COR CIANO
* **Decrease Fruit:** Diminui o tamanho da cobra para o tamanho inicial, sem fornecer nem retirar pontos. COR BRANCA

## Vulnerabilidades do Codigo

Talvez as frutas sejam geradas dentro das barreiras não permitindo o prosseguimento do jogo, necessario recomeçar.
Frutas bombas não são temporarias por isso quando aparecem não tem como prosseguir o jogo, morte inevitavel.