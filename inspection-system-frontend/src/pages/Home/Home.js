import Header from "../../components/Header/Header";
import {Col} from "antd";

function Home() {
    return (
        <Col>
            <Header/>
            <div className="container">
                <div className="row">
                    <div className="col-6 p-5">
                        <div className="col-12 rounded bg-info p-5">Manager</div>
                    </div>
                    <div className="col-6 p-5">
                        <div className="col-12 rounded bg-info p-5">Inspector</div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-6 p-5">
                        <div className="col-12 rounded bg-info p-5">Task</div>
                    </div>
                    <div className="col-6 p-5">
                        <div className="col-12 rounded bg-info p-5">Report</div>
                    </div>
                </div>
            </div>
        </Col>
    );
}

export default Home;