import React from 'react'
import { Button, Card, Table } from 'antd'
import useAppContainerReducer from '../../context/AppContainer/AppContainerReducer'
import {LineChart,  Line,  XAxis,  YAxis,  CartesianGrid,  Tooltip,  Legend,  ResponsiveContainer,} from "recharts";

type Props = {}
const data = [
    {
      name: "Jan",
      income: 4000,
      expense: 2400,
      amt: 2400,
    },
    {
      name: "Feb",
      income: 3000,
      expense: 1398,
      amt: 2210,
    },
    {
      name: "March",
      income: 2000,
      expense: 9800,
      amt: 2290,
    },
    {
      name: "April",
      income: 2780,
      expense: 3908,
      amt: 2000,
    },
    {
      name: "May",
      income: 1890,
      expense: 4800,
      amt: 2181,
    },
    {
      name: "June",
      income: 2390,
      expense: 3800,
      amt: 2500,
    },
    {
      name: "July",
      income: 3490,
      expense: 4300,
      amt: 2100,
    },
    {
      name: "Aug",
      income: 3590,
      expense: 4600,
      amt: 2100,
    },
    {
      name: "Sep",
      income: 1490,
      expense: 1300,
      amt: 2100,
    },
  ];
  
  const dataSource = [
    {
      key: 'month',
      month: 'Expected income %',
      january: 32,
      february: 54,
      march:54,
      april: 32,
      may: 54,
      june:54,
      july: 38,
      august: 64,
      september:95,
  
    },
    {
      key: '2',
      month: 'Expected expense %',
      january: 32,
      february: 54,
      march:54,
      april: 32,
      may: 54,
      june:54,
      july: 38,
      august: 64,
      september:95,
    },
  ];
  
  const columns = [
    {
      title: 'Month',
      dataIndex: 'month',
      key: 'month',
    },
    {
      title: 'January',
      dataIndex: 'january',
      key: 'january',
    },
    {
      title: 'February',
      dataIndex: 'february',
      key: 'february',
    },
    {
      title: 'March',
      dataIndex: 'march',
      key: 'march',
    },
    {
      title: 'April',
      dataIndex: 'april',
      key: 'april',
    },
    {
      title: 'May',
      dataIndex: 'may',
      key: 'may',
    },
    {
      title: 'June',
      dataIndex: 'june',
      key: 'june',
    },
    {
      title: 'July',
      dataIndex: 'july',
      key: 'july',
    },
    {
      title: 'August',
      dataIndex: 'august',
      key: 'august',
    },
    {
      title: 'September',
      dataIndex: 'september',
      key: 'september',
    },
  ];
export default function Home(props: Props): JSX.Element {
    const { methods } = useAppContainerReducer()
    const setLoadingTrue = () => {
        methods.setLoadingTrue()
        setTimeout(methods.setLoadingFalse, 1000)
    }
    return (
        <><div>
        <Card style={{ width: '100%', height: "60%" }}>
          <LineChart
            width={1000}
            height={300}
            data={data}
            margin={{
              top: 5,
              right: 30,
              left: 20,
              bottom: 5,
            }}
          >
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="name" />
            <YAxis />
            <Tooltip />
            <Legend />
            <Line
              type="monotone"
              dataKey="expense"
              stroke="#8884d8"
              activeDot={{ r: 8 }} />
            <Line type="monotone" dataKey="income" stroke="#82ca9d" />
          </LineChart>
        </Card>
      </div><div>
          <Card style={{ width: '100%', height: "60%" }}>
          <Table dataSource={dataSource} columns={columns} />;
          </Card>
        </div></>
    
    )
}
