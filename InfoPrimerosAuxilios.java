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
            ObjetoInfo.setInfo("Primero verifica si la persona puede toser o sacar aire, si este es el caso probablemente es una obstrucción parcial y debes de dejar que tosa el objeto de forma natural sin golperale la espalda\nSi no puede toser:\n1) Abraza a la persona por la espalda y por debajo de sus brazos.\n2) Pon una de tus manos en puno cerrado cuatro dedos encima de su ombligo, en la linea media del estomago\n3) Coloca tu otra mano sobre el puno.\n4)Reclina tu cuerpo un poco hacia delante\n5)Hacé presión sobre el abdomen en sentido hacia atrás y arriba.\nContinuá la maniobra hasta que salga el objeto que obstruye.");
        }
        if(categoria=="Desmayo"){
            ObjetoInfo.setInfo("1) Comprueba que la persona respira, para saber que lo que sufrio es un desmayo.\n2) Verifica que la persona no se haya golpeado, en especial en la cabeza, y que no haya sufrido cortes o fracturas.\n3) Fijate si perdio el conocimiento o si la persona parece perdida o confundida.\n4) Si la persona respira y no esta lastimada ni golpeada, moverla a un lugar con buena ventilacion.\n5) Si se desmayo en un lugar muy caluroso, llevala a un lugar fresco o a la sombra. Si se desmayo en un lugar frío, ponle un abrigo encima para que no le baje la temperatura del cuerpo.\n6) Si perdio el conocimiento, acuestala sobre el piso, aflojale la ropa (botones o cierres del cuello, corbatas) y colocale los pies sobre un objeto alto (el asiento de una silla, una pila de bolsos, una caja), de manera que sus piernas queden elevadas y la presión sanguinea suba.");
        }

        if (categoria=="Fracturas"){
            ObjetoInfo.setInfo("*Si la fractura fue en un brazo o en la mano, retirale el reloj, los anillos y las pulseras.\n*Si la fractura fue en un brazo o pierna, no está expuesta (no sale el hueso a través de la piel) y la persona puede caminar sin ayuda, inmovilizar el miembro y llevar a una guardia médica.\n¿Como inmobilizar una extremidad?\nColocale a lo largo del brazo o pierna herida un objeto rígido y limpio (madera, palo, cartón grueso). El objeto debe ser más largo que el brazo o la pierna, porque tambien tienes que inmovilizar un poco mas alla de las articulaciones, asi el movimiento no le provoca mas dolor. Por ejemplo, si la fractura es en el antebrazo, tienes que inmovilizar tambien el codo y la muneca. Con cuidado, sujetale el objeto al brazo con un paunelo, prenda de ropa o trapo limpio. Si la fractura es en un brazo, podés hacerle además un cabestrillo (apoyabrazo) con un panuelo, tela o bufanda.");
        }

        if(categoria=="Quemadura"){
            ObjetoInfo.setInfo("1) Enfria la herida lo mas rapido posible con agua tibia durante 20 minutos.\n2) No usar hielo, ni agua helada, ni cremas o sustancias grasosas. No reviente la ampolla, puede que se contamine la herida.\n3) Antes de tocar la zona lavar y secar muy bien las manos.\n4) Luego de lavar o remojar la quemadura en agua, cúbrala con un vendaje esteril y seco o con un aposito limpio.\n5) Proteja la quemadura de presiones o fricciones.");
        }
    }


    public InfoPrimerosAuxilios() {
    }


    
    
}
