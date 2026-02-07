fun main() {
    displaymessage(::mourning )
    action(4,3,::sum)
    action(2,5,::subtract)
    action(4,8,::multipy)
}
fun displaymessage(mes : () -> Unit){
    mes()
}
fun mourning(){
    println("good mourning")
}
fun evening(){
    println("good evening")

}
fun action (n1: Int, n2: Int, op: (Int, Int)-> Int){
    val res = op(n1,n2)
    println(res)
}
fun sum(a:Int,b:Int): Int {
    return a+b
}
fun subtract(a:Int,b:Int): Int {
    return a-b
}
fun multipy(a:Int,b:Int): Int {
    return a*b
}
fun empty (a: Int, b:)