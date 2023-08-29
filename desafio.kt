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
    val duracaoTotal get() = conteudos.map { it.duracao }.sum()
    
    fun matricular(vararg usuarios: Usuario) {
        
        inscritos.addAll(usuarios)
        
        println()
        usuarios.forEach {
        	println("${it.nome} foi matriculado com sucesso!")
        }
        
    }
    
}

fun exibirFormacao(formacao: Formacao) {
    
    println()
    println("# ${formacao.nome} - ${formacao.stack} - ${formacao.nivel} [total ${formacao.duracaoTotal}h]")
    
    val categorias = formacao.conteudos.groupBy { it.categoria }
    
    for (categoria in categorias.entries.iterator()) {
        
        println("> ${categoria.key.nome} [${categoria.value.size} conteúdo(s)]")
        for (conteudo in categoria.value) {
        	println(" - ${conteudo.nome} - ${conteudo.nivel} [${conteudo.duracao}h]")
        }
        
    }
    
    val alunos = formacao.inscritos.map { it.nome }.toString()
    println("Inscritos: $alunos")
    
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
