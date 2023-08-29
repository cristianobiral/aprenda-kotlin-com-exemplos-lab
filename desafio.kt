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
	
    // usuários
    val cristiano = Usuario("Cristiano")
    val thiago = Usuario("Thiago")
    val renato = Usuario("Renato")
    
    // formação Java
    val fundamentosJava = Categoria("Fundamentos da Plataforma Java")
    val pooJava = Categoria("Programação Orientada a Objetos em Java")
    val conteudoFormacaoJava = listOf(
        ConteudoEducacional("Introdução à Plataforma Java", Nivel.BASICO, fundamentosJava, 1),
        ConteudoEducacional("Aprendendo a Sintaxe Java", Nivel.BASICO, fundamentosJava, 5),
        ConteudoEducacional("Pilares da Programação O.O. em Java", Nivel.INTERMEDIARIO, pooJava, 2)
    )
    val formacaoJava = Formacao("Formação Java Developer", Stack.DEV_BACKEND, Nivel.INTERMEDIARIO, conteudoFormacaoJava)
    
    formacaoJava.matricular(cristiano, thiago)
    
    exibirFormacao(formacaoJava)
    
    // formação TypeScript
    val introducaoTypeScript = Categoria("Introdução ao React com TypeScript")
    val introducaoNode = Categoria("Introdução ao Node com TypeScript")
    val conteudoTypeScript = listOf(
        ConteudoEducacional("Criando Páginas com React e TypeScript", Nivel.INTERMEDIARIO, introducaoTypeScript, 2),
        ConteudoEducacional("Criando uma Homepage com React", Nivel.AVANCADO, introducaoTypeScript, 1),
        ConteudoEducacional("Criando a API do Dio Bank com Node", Nivel.AVANCADO, introducaoNode, 1)
    )
    val formacaoReact = Formacao("Formação TypeScript Developer", Stack.DEV_FULLSTACK, Nivel.AVANCADO, conteudoTypeScript)
    
    formacaoReact.matricular(renato)
    
    exibirFormacao(formacaoReact)
    
}
