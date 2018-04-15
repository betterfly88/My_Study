describe('ClickCounterView 모듈의',() =>{
    let updateEl;
    let triggerEl;
    let clickCounter;
    let view;

    beforeEach(()=>{
        updateEl = document.createElement('<span></span>');
        triggerEl = document.createElement('<button></button>');
        clickCounter = ClickCounter();
        view  = ClickCounterView(clickCounter, {updateEl, triggerEl})
    })

    describe('updateView()는', () => {
        it('ClickCounter의 getCounter()의 값을 출력한다', ()=> {
            const counterValue = clickCounter.getCounter().toString();
            view.updateView();
            expect(updateEl.text()).toBe(counterValue);


        })
        // it('에러를 번환한다',()=>{
        //     expect(function(){ throw new Error()}).toThrowError();
        // })
    })
})
