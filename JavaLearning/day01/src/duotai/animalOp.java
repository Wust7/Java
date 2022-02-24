package duotai;

public class animalOp {
    public void useAnimal(animal a){
        a.eat();
    }
    public  void useJumpping(Jumpping j){
        //传入的同样需要是Jumpping的实现类，而不是该接口
        j.jump();
    }

    public Jumpping useInterface(){
        //返回的同样是接口的实现类
        Jumpping j = new dog();
        return j;
    }
}
