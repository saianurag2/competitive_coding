def simulate_trade(buyers,sellers):
    # for seller in sellers:
    return


if __name__ == '__main__':
    num_bids = int(input())
    sellers = list()
    buyers = list()
    while num_bids > 0:
        trade_offer = input().split(' ')
        if len(trade_offer) == 5:
            trade_id = int(trade_offer[0])
            trade_type = trade_offer[1]
            stock_name = trade_offer[2]
            price = float(trade_offer[3])
            qty = int(trade_offer[4])
            trader_entry = {'TradeID':trade_id, 'TradeType': trade_type, 'StockName': stock_name,'Price':price, 'Quantity':qty}
            if trade_type == 'Sell':
                sellers.append(trader_entry)
            else:
                buyers.append(trader_entry)
        num_bids = num_bids - 1
    simulate_trade(buyers, sellers)






