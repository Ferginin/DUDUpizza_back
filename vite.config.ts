import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/api': {  // Префикс для ваших API-запросов
        target: 'http://26.67.82.77:8080',  // Адрес вашего сервера
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ''),  // Убираем префикс /api
      },
    },
  },
});