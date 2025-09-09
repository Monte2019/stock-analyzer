📈 Stock Analyzer

Stock Analyzer is a work-in-progress application designed to help users fetch, analyze, and visualize stock market data in real time. The tool leverages modern backend technologies to support fast data processing, storage, and retrieval, making it easier for users to perform stock trend analysis and backtesting.

🔧 Tech Stack

  -Java / Spring Boot – core application framework
  -PostgreSQL – relational database for persistent storage
  -Redis – caching layer to speed up stock data queries and real-time analytics
  -Docker – containerized environment for consistent development and deployment

🚀 Current Features

  -Basic configuration for PostgreSQL and Redis.
  -Service layer for ingesting and retrieving stock data.
  -Early endpoints to fetch stock details (in development).
  -Currently grabbing a few stocks once per daily instead of constantly to not hit quota.

🛠 Planned Features / Roadmap

  -Real-time stock price fetching and caching.
  -Technical analysis indicators (moving averages, RSI, MACD).
  -Portfolio management (track holdings, gains/losses).
  -Alert system for price movements or signals.
  -REST API for external integrations.
  -Frontend dashboard for visualizing stock trends.
