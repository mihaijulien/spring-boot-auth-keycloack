import type { BookModel } from '../model/BookModel.ts';

const BASE_URL = import.meta.env.VITE_BASE_URL;

interface BookResponse {
    content: BookModel[];
    totalElements: number;
    totalPages: number;
}

export const bookService =  {
    // All the services regarding books

    async getBooks(pageNo: number, pageSize: number): Promise<BookResponse> {
        const response = await fetch(
            `${BASE_URL}/books?pageNo=${pageNo}&pageSize=${pageSize}`
        );
        if (!response.ok) {
            throw new Error("Fail to fetch books");
        }
        return await response.json();
    }
}