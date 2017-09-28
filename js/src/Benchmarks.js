import Benchmark from 'benchmark';
let suite = new Benchmark.Suite();

import * as kataFP from './App';
import * as kataImp from './AppImp';


suite.add('KataZeroA functional Benchmark', function () {
        kataFP.ZeroA();
    })
    .add('KataZeroA imperative Benchmark', function () {
        kataImp.ZeroA();
    })


    .on('cycle', function (event) {
        console.log(String(event.target));
    })
    .on('complete', function () {
        console.log('Fastest is ' + this.filter('fastest').map('name'));
    })


    .run({'async': true});