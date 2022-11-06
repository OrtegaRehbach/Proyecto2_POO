public class InfoPrimerosAuxilios {
    private String categoria;
    private String info;
    
    public InfoPrimerosAuxilios(String categoria, String info) {
        this.categoria = categoria;
        this.info = info;
    }

    public void Category(String categoria){
        this.categoria=categoria;

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void ReturnInfo(String categoria, InfoPrimerosAuxilios ObjetoInfo){
        if( categoria=="Asfixia"){
            ObjetoInfo.setInfo("Primero verifica si la persona puede toser o sacar aire, si este es el caso probablemente es una obstrucción parcial y debes de dejar que tosa el objeto de forma natural sin golperale la espalda\nSi no puede toser:\n1)Abrazá a la persona por la espalda y por debajo de sus brazos.\n2)Poné una de tus manos en puño cerrado cuatro dedos encima de su ombligo, en la línea media del estómago\n3)Coloca tu otra mano sobre el puño.\n4)Reclina tu cuerpo un poco hacia delante\n5)Hacé presión sobre el abdomen en sentido hacia atrás y arriba.\nContinuá la maniobra hasta que salga el objeto que obstruye.");
        }
        if(categoria=="Desmayo"){
            ObjetoInfo.setInfo("1)Comprobá que la persona respira, para saber que lo que sufrió es un desmayo.\n2)Verificá que la persona no se haya golpeado, en especial en la cabeza, y que no haya sufrido cortes o fracturas.\n3)Fijate si perdió el conocimiento o parece como perdida o confundida.\n4)Si la persona respira y no está lastimada ni golpeada, movela a un lugar con buena ventilación.\n5)Si se desmayó en un lugar muy caluroso, llevala a un lugar fresco o a la sombra. Si se desmayó en un lugar frío, ponele un abrigo encima para que no le baje la temperatura del cuerpo.\n6)Si perdió el conocimiento, acostala sobre el piso, aflojale la ropa (botones o cierres del cuello, corbatas) y colocale los pies sobre un objeto alto (el asiento de una silla, una pila de bolsos, una caja), de manera que sus piernas queden elevadas y la presión sanguínea suba.");
        }

        if (categoria=="Fracturas"){
            ObjetoInfo.setInfo("*Si la fractura fue en un brazo o en la mano, retirale el reloj, los anillos y las pulseras.\n*Si la fractura fue en un brazo o pierna, no está expuesta (no sale el hueso a través de la piel) y la persona puede caminar sin ayuda, inmovilizá el miembro y llevar a una guardia médica.\n¿Como inmobilizar una extremidad?\nColocale a lo largo del brazo o pierna herida un objeto rígido y limpio (madera, palo, cartón grueso). El objeto debe ser más largo que el brazo o la pierna, porque también tenés que inmovilizar un poco más allá de las articulaciones, así el movimiento no le provoca más dolor. Por ejemplo, si la fractura es en el antebrazo, tenés que inmovilizar también el codo y la muñeca.Con cuidado, sujetale el objeto al brazo con un pañuelo, prenda de ropa o trapo limpio. Si la fractura es en un brazo, podés hacerle además un cabestrillo (apoyabrazo) con un pañuelo, tela o bufanda.");
        }

        if(categoria=="Quemadura"){
            ObjetoInfo.setInfo("1)Enfría la herida lo más rápido posible con agua tibia durante 20 minutos.\n2)No usar hielo, ni agua helada, ni cremas o sustancias grasosas. No reviente la ampolla, puede que se contamine la herida.\n3)Antes de tocar la zona lavar y secar muy bien las manos.\n4)Luego de lavar o remojar la quemadura en agua, cúbrala con un vendaje estéril y seco o con un apósito limpio.\n5)Proteja la quemadura de presiones o fricciones.");
        }
    }


    public InfoPrimerosAuxilios() {
    }


    
    
}
