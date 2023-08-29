package me.dio.track

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
enum class Stack { DEV_BACKEND, DEV_FULLSTACK, ENG_DADOS }

data class Usuario(val nome: String)

data class Categoria(val nome: String)

data class ConteudoEducacional(
    val nome: String,
    val nivel: Nivel,
    val categoria: Categoria,
    val duracao: Int = 1
)

data class Formacao(
    val nome: String,
    val stack: Stack,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>
) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
