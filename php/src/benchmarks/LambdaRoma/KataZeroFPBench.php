<?php
namespace benchmarks\LambdaRoma\KataZero;

use LambdaRoma\KataZero\KataZeroFP;

/**
 * Class KataZeroQaribuBench
 * @Groups({"functional", "mutable"})
 * @BeforeMethods({"init"})
 * @Revs(1000)
 * @Iterations(2)
 */
class KataZeroFPBench
{
    private $subject;
    private $men = ["Tizio", "Caio", "Sempronio", "Mevio", "Filano", "Calpurnio"];
    private $women = ["Anna", "Carla", "Angela", "Chiara", "Emma", "Maria", "Sara"];

    public function init()
    {
        $this->subject = new KataZeroFP();
    }

    public function benchKataZeroA()
    {
        $this->subject->kataZeroA();
    }

    public function benchKataZeroB()
    {
        $this->subject->kataZeroB();
    }

    public function benchKataZeroC()
    {
        $this->subject->kataZeroC();
    }

    public function benchKataZeroD()
    {
        $this->subject->kataZeroD($this->men);
    }

    public function benchKataZeroE()
    {
        $this->subject->kataZeroE();
    }

    public function benchKataZeroF()
    {
        $this->subject->kataZeroF();
    }

    public function benchKataZeroG()
    {
        $this->subject->kataZeroG($this->men);
    }

    public function benchKataZeroI()
    {
        $this->subject->kataZeroI($this->men);
    }

    public function benchKataZeroJ()
    {
        $this->subject->kataZeroJ($this->men);
    }

    public function benchKataZeroK()
    {
        $this->subject->kataZeroK($this->women);
    }

    public function benchKataZeroL()
    {
        $this->subject->kataZeroL($this->women);
    }

    public function benchKataZeroM()
    {
        $this->subject->kataZeroM($this->women);
    }
}