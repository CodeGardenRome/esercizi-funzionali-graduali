package lambdaroma;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import lambdaroma.LambdaGardenDue.Cella;

public class LambdaGardenDueTest {

    LambdaGardenDue lambdaGardenDue = new LambdaGardenDue();

    Character[][] matriceA = {
            {' ', 'O', 'X'},
            {' ', 'X', 'O'},
            {'X', ' ', ' '} };

    Character[][] matriceB = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '} };

    Character[][] matriceC = {
            {' ', 'X', 'O'},
            {' ', 'O', 'X'},
            {'O', ' ', ' '} };

    Character[][] matriceD = {
            {'O', 'O', ' '},
            {'X', 'X', 'X'},
            {' ', ' ', ' '} };

    Character[][] matrice10x10 = {
            {'X',' ',' ',' ',' ',' ',' ',' ','O',' '},
            {' ','X',' ',' ',' ',' ',' ',' ','O',' '},
            {' ',' ','X',' ',' ',' ',' ',' ','O',' '},
            {' ',' ',' ','X',' ',' ',' ',' ','O',' '},
            {' ',' ',' ',' ','X',' ',' ',' ','O',' '},
            {' ',' ',' ',' ',' ','X',' ',' ','O',' '},
            {' ',' ',' ',' ',' ',' ','X',' ','O',' '},
            {' ',' ',' ',' ',' ',' ',' ','X','O',' '},
            {' ',' ',' ',' ',' ',' ',' ',' ','X','O'},
            {' ',' ',' ',' ',' ',' ',' ',' ','O','X'}  };

    @Test
    void verificaParteA(){
        Character[] rigaX = {'X','X','X'};
        assertEquals('X', lambdaGardenDue.vincitore(rigaX));
        Character[] rigaO = {'O','O','O'};
        assertEquals('O', lambdaGardenDue.vincitore(rigaO));
        Character[] rigaSpazio = {' ',' ',' '};
        assertEquals(' ', lambdaGardenDue.vincitore(rigaSpazio));
        Character[] rigaMistaA = {' ',' ',' '};
        assertEquals(' ', lambdaGardenDue.vincitore(rigaMistaA));
        Character[] rigaMistaB = {' ','X','O'};
        assertEquals(' ', lambdaGardenDue.vincitore(rigaMistaB));
        Character[] rigaMistaC = {'O','X','O'};
        assertEquals(' ', lambdaGardenDue.vincitore(rigaMistaC));
    }

    @Test
    void verificaParteB(){
        assertEquals(new Cella(2,2), lambdaGardenDue.cellaSuccessivaRighe(new Cella(2,1)));
        assertEquals(new Cella(2,1), lambdaGardenDue.cellaSuccessivaColonne(new Cella(1,1)));
        assertEquals(new Cella(2,2), lambdaGardenDue.cellaSuccessivaDiagonaleMaggiore(new Cella(1,1)));
        assertEquals(new Cella(1,1), lambdaGardenDue.cellaSuccessivaDiagonaleMinore(new Cella(2,0)));
    }

    @Test
    void verificaParteC(){
        Character[] rigaA = {' ','O','X'};
        assertArrayEquals(rigaA, lambdaGardenDue.generaVettore(matriceA,new Cella(0,0), lambdaGardenDue::cellaSuccessivaRighe));
        Character[] rigaB = {' ',' ','X'};
        assertArrayEquals(rigaB, lambdaGardenDue.generaVettore(matriceA,new Cella(0,0), lambdaGardenDue::cellaSuccessivaColonne));
        Character[] rigaC = {' ','X',' '};
        assertArrayEquals(rigaC, lambdaGardenDue.generaVettore(matriceA,new Cella(0,0), lambdaGardenDue::cellaSuccessivaDiagonaleMaggiore));
        Character[] rigaD = {'X','X','X'};
        assertArrayEquals(rigaD, lambdaGardenDue.generaVettore(matriceA,new Cella(2,0), lambdaGardenDue::cellaSuccessivaDiagonaleMinore));
    }

    @Test
    void verificaParteD1(){
        assertEquals(Character.valueOf('X'), lambdaGardenDue.vincitoreMatrice(matriceA));
    }

    @Test
    void verificaParteD2(){
        assertEquals(Character.valueOf(' '), lambdaGardenDue.vincitoreMatrice(matriceB));
    }

    @Test
    void verificaParteD3(){
        assertEquals(Character.valueOf('O'), lambdaGardenDue.vincitoreMatrice(matriceC));
    }

    @Test
    void verificaParteD4(){
        assertEquals(Character.valueOf('X'), lambdaGardenDue.vincitoreMatrice(matriceD));
    }

    @Test
    void verificaParteE(){
        assertEquals(Character.valueOf('X'), lambdaGardenDue.vincitoreMatrice(matrice10x10));
    }
}
