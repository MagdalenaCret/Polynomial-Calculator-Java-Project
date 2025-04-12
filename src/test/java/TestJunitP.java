import org.assignment_1.exception_package.ExceptionDivide;
import org.assignment_1.polynomial_calculator.Polynomial;
import org.assignment_1.polynomial_calculator.PolynomialOperation;
import org.assignment_1.polynomial_calculator.PolynomialRead;
import org.junit.*;

import java.security.DigestException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestJunitP {
        private static int numberOfTestsPerformed = 0;
        private static int numberOfTestsSuccess = 0;
    private static PolynomialOperation polynomialCalculator;

        @BeforeClass
        public static void setUpBeforeClass() throws Exception {
            polynomialCalculator =new PolynomialOperation();
        }
        @Before
        public void setUpForTestingWhenTestStart() throws Exception {
            System.out.print("---Start a new test---");
        }

       //Partea de testare, testele unitare realizate pentru fiecare din operatiile efectuate in clasa PolynomialOperatiom

       //Teste Unitare pentru Adunare
        @org.junit.Test
        public void testAddNumber1(){
            System.out.print("Test Number 1 for Add Operation:\n");

            Polynomial polynomial1 =  PolynomialRead.readPolynomial("6x^4+3x^2-5x-8");
            Polynomial polynomial2 =  PolynomialRead.readPolynomial("2x^-2+5x-6");

            Polynomial waitingResult = PolynomialRead.readPolynomial("6x^4+3x^2+2x^-2-14");
            Polynomial obtainedResult = PolynomialOperation.addPolynomial(polynomial1,polynomial2);

            //System.out.println(obtainedResult);
            //Assert.assertEquals(obtainedResult.toString(),waitingResult.toString());
            boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }
        @org.junit.Test
        public void testAddNumber2(){
            System.out.print("Test Number 2 for Add Operation:\n");

            Polynomial polynomial1 =  PolynomialRead.readPolynomial("4x^6+3x^2-5x-8");
            Polynomial polynomial2 =  PolynomialRead.readPolynomial("-3x^2");

            Polynomial waitingResult = PolynomialRead.readPolynomial("4x^6-5x-8");
            Polynomial obtainedResult = PolynomialOperation.addPolynomial(polynomial1,polynomial2);

            //System.out.println(obtainedResult);
            //Assert.assertEquals(obtainedResult.toString(),waitingResult.toString());
            boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }

    //Teste Unitare pentru Scadere
        @org.junit.Test
        public void testSubNumber1() {
            System.out.print("Test Number 1 for Sub Operation:\n");

            Polynomial polynomial1 =  PolynomialRead.readPolynomial("4x^6");
            Polynomial polynomial2 =  PolynomialRead.readPolynomial("2x-1");

            Polynomial waitingResult = PolynomialRead.readPolynomial("4x^6-2x+1");
            Polynomial obtainedResult = PolynomialOperation.subPolynomial(polynomial1,polynomial2);

            boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }
    @org.junit.Test
    public void testSubNumber2() {
        System.out.print("Test Number 2 for Sub Operation:\n");

        Polynomial polynomial1 =  PolynomialRead.readPolynomial("4x^5-2x^-4");
        Polynomial polynomial2 =  PolynomialRead.readPolynomial("4x^5+1");

        Polynomial waitingResult = PolynomialRead.readPolynomial("-2x^-4-1");
        Polynomial obtainedResult = PolynomialOperation.subPolynomial(polynomial1,polynomial2);

        boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
        Assert.assertTrue(testVerify);
        numberOfTestsSuccess = numberOfTestsSuccess + 1;
    }
//Teste pentru inmultire
        @org.junit.Test
        public void testMulNumber1() {
            System.out.print("Test Number 1 for Mul Operation:\n");

            Polynomial polynomial1 =  PolynomialRead.readPolynomial("2x^2+3x+5x^3-2");
            Polynomial polynomial2 =  PolynomialRead.readPolynomial("3x-1");

            Polynomial waitingResult = PolynomialRead.readPolynomial("15x^4+x^3+7x^2-9x+2");
            Polynomial obtainedResult = PolynomialOperation.mulPolynomial(polynomial1,polynomial2);

            boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }

    @org.junit.Test
    public void testMulNumber2() {
        System.out.print("Test Number 2 for Mul Operation:\n");

        Polynomial polynomial1 =  PolynomialRead.readPolynomial("2x^2+3x+5x^3-2");
        Polynomial polynomial2 =  PolynomialRead.readPolynomial("0");

        Polynomial waitingResult = PolynomialRead.readPolynomial("0");
        Polynomial obtainedResult = PolynomialOperation.mulPolynomial(polynomial1,polynomial2);

        boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
        Assert.assertTrue(testVerify);
        numberOfTestsSuccess = numberOfTestsSuccess + 1;
    }


  //Teste Unitare pentru Impartire
         @org.junit.Test(expected = ExceptionDivide.class)
         public void testDivisionNumber1() throws ExceptionDivide {
            System.out.print("Test Number 1 for Div Operation:\n");

             Polynomial polynomial1 =  PolynomialRead.readPolynomial("2x^2+3x+5");
             Polynomial polynomial2 =  PolynomialRead.readPolynomial("0");

            PolynomialOperation.divisionPolynomial(polynomial1, polynomial2);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }

         @org.junit.Test(expected = ExceptionDivide.class)
         public void testDivisionNumber2() throws ExceptionDivide {
             System.out.print("Test Number 2 for Div Operation:\n");

             Polynomial polynomial1 =  PolynomialRead.readPolynomial("6x^5-17x^3-x^2+3");
             Polynomial polynomial2 =  PolynomialRead.readPolynomial("3x^7");

            PolynomialOperation.divisionPolynomial(polynomial1, polynomial2);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }
         @org.junit.Test
         public void testDivisionNumber3() throws ExceptionDivide {
             System.out.print("Test Number 3 for Div Operation:\n");

            Polynomial polynomial1 =  PolynomialRead.readPolynomial("6x^5-17x^3-x^2+3");
            Polynomial polynomial2 =  PolynomialRead.readPolynomial("3x^2-6x+2");

            String waitingResult = "Quotient: 2.0*x^3+4.0*x^2+x-1.0   Remainder: -8.0*x+5.0";
            String obtainedResult = PolynomialOperation.divisionPolynomial(polynomial1,polynomial2);
            //System.out.println(obtainedResult);
            boolean testVerify = obtainedResult.equals(waitingResult);
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }
        @org.junit.Test
        public void testDivisionNumber4() throws ExceptionDivide {
            System.out.print("Test Number 4 for Div Operation:\n");

            Polynomial polynomial1 =  PolynomialRead.readPolynomial("6x^5-17x^3-x^2+3");
            Polynomial polynomial2 =  PolynomialRead.readPolynomial("1");

            String waitingResult = "Quotient: 6.0*x^5-17.0*x^3-x^2+3.0   Remainder: 0";
            String obtainedResult = PolynomialOperation.divisionPolynomial(polynomial1,polynomial2);
            //System.out.println(obtainedResult);
            boolean testVerify = obtainedResult.equals(waitingResult);
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
    }
    //Teste Unitare pentru Derivare
        @org.junit.Test
        public void testDerivativeNumber1() {
            System.out.print("Test Number 1 for Derivative Operation:\n");

            Polynomial polynomial =  PolynomialRead.readPolynomial("8");
            Polynomial waitingResult = PolynomialRead.readPolynomial("0");
            Polynomial obtainedResult = PolynomialOperation.derivativePolynomial(polynomial);

            boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }

        @org.junit.Test
        public void testDerivativeNumber2() {
            System.out.print("Test Number 2 for Derivative Operation:\n");

            Polynomial polynomial =  PolynomialRead.readPolynomial("2x-1");
            Polynomial waitingResult = PolynomialRead.readPolynomial("2");
            Polynomial obtainedResult = PolynomialOperation.derivativePolynomial(polynomial);

            boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }

        @org.junit.Test
        public void testDerivativeNumber3() {
            System.out.print("Test Number 3 for Derivative Operation:\n");

            Polynomial polynomial =  PolynomialRead.readPolynomial("2x^6+3x^4+2x+0");
            Polynomial waitingResult = PolynomialRead.readPolynomial("12x^5+12x^3+2");
            Polynomial obtainedResult = PolynomialOperation.derivativePolynomial(polynomial);

            boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }

    //Teste Unitare pentru Integrare
            @org.junit.Test
            public void testIntegrativeNumber1() {
            System.out.print("Test Number 1 for Integrative Operation:\n");

            Polynomial polynomial =  PolynomialRead.readPolynomial("7x^6+5x^4+2x");
            Polynomial waitingResult = PolynomialRead.readPolynomial("x^7+x^5+x^2");
            Polynomial obtainedResult = PolynomialOperation.integratePolynomial(polynomial);

            boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }

        @org.junit.Test
        public void testIntegrativeNumber2() {
            System.out.print("Test Number 2 for Integrative Operation:\n");

            Polynomial polynomial =  PolynomialRead.readPolynomial("8x^3-2x+8");
            Polynomial waitingResult = PolynomialRead.readPolynomial("2x^4-x^2+8x");
            Polynomial obtainedResult = PolynomialOperation.integratePolynomial(polynomial);

            boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
        }

        @org.junit.Test
        public void testIntegrativeNumber3() {
            System.out.print("Test Number 3 for Integrative Operation:\n");

            Polynomial polynomial =  PolynomialRead.readPolynomial("2x-6");
            Polynomial waitingResult = PolynomialRead.readPolynomial("x^2-6x");
            Polynomial obtainedResult = PolynomialOperation.integratePolynomial(polynomial);

            boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
            Assert.assertTrue(testVerify);
            numberOfTestsSuccess = numberOfTestsSuccess + 1;
    }

    @org.junit.Test
    public void testReadNumber1() {
        System.out.print("Test Number 1 for Read Polynomial Method:\n");

        Polynomial polynomial =  PolynomialRead.readPolynomial("2x+3x^4-3x^-3+0-5x^2");
        Polynomial waitingResult = PolynomialRead.readPolynomial("3.0*x^4-5.0*x^2+2.0*x-3.0*x^(-3)");
        Polynomial obtainedResult = PolynomialRead.readPolynomial(polynomial.toString());

        boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
        Assert.assertTrue(testVerify);
        numberOfTestsSuccess = numberOfTestsSuccess + 1;
    }

    @org.junit.Test
    public void testReadNumber2() {
        System.out.print("Test Number 2 for Read Polynomial Method:\n");

        Polynomial polynomial =  PolynomialRead.readPolynomial("2x+3x^4-3x^2-1");
        Polynomial waitingResult = PolynomialRead.readPolynomial("3.0*x^4-3.0*x^2+2.0*x-1.0");
        Polynomial obtainedResult = PolynomialRead.readPolynomial(polynomial.toString());

        boolean testVerify = obtainedResult.toString().equals(waitingResult.toString());
        Assert.assertTrue(testVerify);
        numberOfTestsSuccess = numberOfTestsSuccess + 1;

    }

    @After
    public void testResponse(){
        System.out.println("\n---The current test was executed---\n");
        numberOfTestsPerformed = numberOfTestsPerformed + 1;
    }
    @AfterClass
    public static void finalResultTesting(){
        System.out.println("---They were executed " + numberOfTestsPerformed + " tests of which "+ numberOfTestsSuccess + "\n" + "tests successfully---");
    }
}