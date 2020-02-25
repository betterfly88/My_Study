package net.class101.server1.service;

import net.class101.server1.model.ClientState;
import lombok.RequiredArgsConstructor;
import net.class101.server1.model.User;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class OrderExecutor {
    private final OrderProcessService orderService;

    public void execute(){
        System.out.println("입력(o[order]): 주문 , q[quit]: 종료) :");
        Scanner sc = new Scanner(System.in);

        System.out.println("이름을 입력해주세요.");
        String userName = sc.nextLine();

        User user = new User(userName);
        while(true){
            String input = sc.nextLine();

            ClientState state = ClientState.getClientState(input);
            if(state == null){
                System.out.println("'o'(주문) 또는 'q'(종료)를 입력해주세요.");
                continue;
            }

            switch (state){
                case ORDER:
                    orderService.getProductList().values().forEach(v ->{
                        System.out.println(v.toString());
                    });

                    System.out.print("상품번호 : ");
                    long pId = sc.nextLong();
                    System.out.print("수량 : ");
                    int pCount = sc.nextInt();

                    user.setProductId(pId);
                    user.setOrderCounts(pCount);
                    orderService.addItem(user);
                    break;
                case EXECUTE:
                    orderService.order();
                    break;
                case QUIT:
                    orderService.exitOrder();
                    break;
                default:
                    System.out.println("'o'(주문) 또는 'q'(종료)를 입력해주세요.");
                    break;
            }
        }
    }


}
