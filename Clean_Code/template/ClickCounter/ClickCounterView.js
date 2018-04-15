var ClickCounterView = function(clickCounter, options){

    const view = {
        updateView(){
            options.updateEl.innerHTML = clickCounter.getCounter();
        },
        updateAndView(){
            clickCounter.getCounter();
            view.updateView();
        }
    }
    options.triggerEl.on('click', ()=>{
        view.updateAndView();
    })
    return view;


    const view = {
        countAndUpdateView() {
            counter.count()
            view.updateView()
        },
    }

    options.triggerEl.addEventListener('click', () => {
        view.countAndUpdateView()
    })
}