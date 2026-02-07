fun main() {
    displaymessage(::mourning )
    action(4,3,::sum)
    action(2,5,::subtract)
    action(4,8,::multipy)
    val act1 = selectaction(1)
    println(act1(8,5))
    val act2 = selectaction(2)
    println(act2(8,5))
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
fun selectaction(key: Int): (Int, Int) -> Int{
    return when(key){
        1 -> ::sum
        2 -> ::subtract
        3 ->::multipy
        else -> ::empty
    }
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
fun empty (a: Int, b:Int): Int{
    return 0
}
