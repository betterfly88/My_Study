// describe('ClickCounter 모듈의', () =>{
//     describe('getCounter()는 ', ()=>{
//         it('초기값이 0인 카운터를 반환한다', ()=>{
//             //TODO
//             const counter = ClickCounter()
//
//             const expected = counter.getCounter()
//
//             expect(expected).toBe(0);
//         })
//     })
// })



describe('click counter 모듈의',() =>{
    let clickCounter
    beforeEach(()=> { // 1{
        clickCounter = ClickCounter();
    })

    describe('increase()는', () => {
        it('초기값이 1인 카운터를 반환한다', ()=> {
            // const counter = ClickCounter();
            // spyOn(clickCounter,'increase');
            clickCounter.increase()
            expect(clickCounter.getCounter()).toBe(1)
        })
    })
})


// describe('click counter',() =>{
//     // let coutner;
//     beforeEach(()=>{ // 1
//         // afterEach(()=>{ // 3
//             it('test start', () => { //2
//
//                 var counter = ClickCounter();
//
//                 counter.increase();
//                 expect(counter.getCounter()).toBe(1);
//             })
//         // })
//     })
// })