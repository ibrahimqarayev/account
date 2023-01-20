import logo from './logo.svg';
import './App.css';
import {Component} from "react";


class App extends Component {
    state = {
        customer: {
            accounts: []
        }
    };

    async componentDidMount() {
        const response = await fetch('/v1/customer/099379a5-0785-4472-ab31-daaf7aa0d1c6');
        const body = await response.json();
        this.setState({customer: body});
    }

    render() {
        const {customer} = this.state;
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <div className="App-intro">
                        <h2>Customer</h2>
                        <div key={customer.id}>
                            {customer.name} {customer.surname}
                            {
                                customer.accounts.map(account =>
                                    (<p> Account : {account.id} , {account.balance},{account.creationDate}
                                        {
                                            account.transactions.map(transaction =>
                                                (<p> Transaction : {transaction.id},{transaction.amount},
                                                    {transaction.transactionDate},{transaction.transactionType}
                                                </p>)
                                            )
                                        }
                                    </p>)
                                )
                            }
                        </div>
                    </div>
                </header>
            </div>
        );
    }
}

export default App;
