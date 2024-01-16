import java.io.IOException

// Refatorado por Nathalia Soares

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

enum class Tipo { FRONTEND, BACKEND, DATA_SCIENCE }

data class Usuario(val nome: String, val matricula: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int, val tipo: Enum<Tipo>,  val Nivel: Enum<Nivel>)

data class Formacao(val nome: String) {

    val inscritos = mutableListOf<Usuario>()
    val conteudos = mutableListOf<ConteudoEducacional>()

    fun adicionarConteudo(conteudoEducacional: ConteudoEducacional) {
        conteudos.add(conteudoEducacional)
        try {
            println("Conteúdo ${conteudoEducacional.nome} adicionado com sucesso!")
        } catch(e: IOException) {
            println("Não foi possível adicionar o conteúdo $conteudoEducacional.nome")
        }
    }

    fun listarConteudos(formacao: Formacao) {
        println("------------------------------")
        println("Conteúdo da formação ${formacao.nome}")
        for(conteudo in conteudos) {
            println(conteudo.nome)
        }
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        try {
            println("A matrícula de ${usuario.nome} foi realizada com sucesso!")
        } catch(e: IOException) {
            println("Não foi possível realizar a sua matrícula. Tente novamente mais tarde")
        }

    }

    fun listarInscritos(formacao: Formacao) {
        println("------------------------------")
        println("Alunos inscritos na formação ${formacao.nome}")
        for(inscrito in inscritos) {
            println("Nome: ${inscrito.nome}")
            println("Matrícula: ${inscrito.matricula}")
            println("---------------------------------")
        }
    }
}

fun main() {

    var usuario1 = Usuario("Nathalia", 123456789)
    var usuario2 = Usuario("Maria", 987654321)
    var usuario3 = Usuario("João", 321654987)

    val conteudo1 = ConteudoEducacional("Kotlin - Lógica de Programação", 40, Tipo.BACKEND, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Kotlin - Orientado a Objetos", 22, Tipo.BACKEND, Nivel.BASICO)
    val conteudo3 = ConteudoEducacional("Kotlin - Exceções", 53, Tipo.BACKEND, Nivel.INTERMEDIARIO)

    val formacao = Formacao("Kotlin")

    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)
    formacao.adicionarConteudo(conteudo3)

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)

    formacao.listarConteudos(formacao)
    formacao.listarInscritos(formacao)
}