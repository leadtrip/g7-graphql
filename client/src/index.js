import React from 'react';
import { createRoot } from 'react-dom/client';
import App from './App';
import './css/bootstrap.css';
import './css/App.css';
import './css/grails.css';
import './css/main.css';
import { ApolloClient, InMemoryCache, ApolloProvider, createHttpLink } from '@apollo/client';
import { SERVER_URL } from "./config";

const client = new ApolloClient({
  link: createHttpLink({ uri: `${SERVER_URL}/graphql` }),
  cache: new InMemoryCache()
});

const container = document.getElementById('root');
const root = createRoot(container);

root.render(
    <ApolloProvider client={client}>
      <App />
    </ApolloProvider>
);